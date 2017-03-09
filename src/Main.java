import net.i2p.crypto.eddsa.EdDSAEngine;
import net.i2p.crypto.eddsa.EdDSAPrivateKey;
import net.i2p.crypto.eddsa.Utils;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;

public class Main {

    public static final String PRIVATE_KEY_HEX_STR = "0A041B9462CAA4A31BAC3567E0B6E6FD9100787DB2AB433D96F6D178CABFCE90009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E";
    public static final String PUBLIC_KEY_HEX_STR = "009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E";
    public static final String ADDRESS_HEX_STR = "1563AB099BDFF3CF9B6AAB012C2EBFACC21F8A80";
    public static final String DATA = "data to be signed!";
    public static final String SIGNATURE_EXPECTED = "a49114c81bc773faad33f3ba0cc82a05550d08434e2c1dd739b18f028d93fb494e2defc9f7e9b345fbfdd4ac5d95ffa0b6dc8a1b74d268eba4665ba3e8d22f0a";

    public static void main(String[] args) throws Exception {
        EdDSAParameterSpec spec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.CURVE_ED25519_SHA512);

        // Utils.hexToBytes("0000000000000000000000000000000000000000000000000000000000000000")
        // Utils.hexToBytes("0A041B9462CAA4A31BAC3567E0B6E6FD9100787DB2AB433D96F6D178CABFCE90")
        EdDSAPrivateKeySpec privKey = new EdDSAPrivateKeySpec(Utils.hexToBytes("0A041B9462CAA4A31BAC3567E0B6E6FD9100787DB2AB433D96F6D178CABFCE90"), spec);
        PrivateKey sKey = new EdDSAPrivateKey(privKey);

        Signature sgr = new EdDSAEngine(MessageDigest.getInstance(spec.getHashAlgorithm()));
        sgr.initSign(sKey);
        sgr.update(DATA.getBytes());

        byte[] signbyte = sgr.sign();
        String signstr = Utils.bytesToHex(signbyte);

        System.out.println("signstr: " + signstr);

        if (!SIGNATURE_EXPECTED.equals(signstr)) {
            System.out.println("Not Equal!");
        }


        ////
        // go-wire       009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E
        // become  010120009e64c1b4731be7df39a40d5660d84e23885fc465db5ddad425789c68cf1a8e

        byte[] pubkey_bin = Utils.hexToBytes(PUBLIC_KEY_HEX_STR);

        byte[] pubkey_wire = new byte[35];
        pubkey_wire[0] = 0x01;
        pubkey_wire[1] = 0x01;
        pubkey_wire[2] = 0x20;
        System.arraycopy(pubkey_bin, 0, pubkey_wire, 3, 32);
        System.out.println("pubkey_wire: " + Utils.bytesToHex(pubkey_wire));

        // test the hash Ripemd160
        Ripemd160 ripemd160 = new Ripemd160();
        ripemd160.engineUpdate(pubkey_wire, 0, pubkey_wire.length);

        String address = Utils.bytesToHex(ripemd160.engineDigest());
        System.out.println("address: " + address);


    }


}
