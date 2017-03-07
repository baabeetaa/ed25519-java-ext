# Intro

Experiment the ed25519 signing using [ed25519-java](https://github.com/str4d/ed25519-java)
for the Back-End and Android client to publish transaction to the [chaincore](https://gitlab.com/cashconnectgroup/chaincore) directly.

# Data
```
2017/03/07 16:11:37 crypto.go:80: ------------------------------------------------------------
2017/03/07 16:11:37 crypto.go:81: secret=			user1
2017/03/07 16:11:37 crypto.go:82: _priKeyHex=			010A041B9462CAA4A31BAC3567E0B6E6FD9100787DB2AB433D96F6D178CABFCE90009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E
2017/03/07 16:11:37 crypto.go:83: PubKey Hex=			01009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E
2017/03/07 16:11:37 crypto.go:84: PubKey KeyString=	009E64C1B4731BE7DF39A40D5660D84E23885FC465DB5DDAD425789C68CF1A8E
2017/03/07 16:11:37 crypto.go:85: PubKey Address=		1563AB099BDFF3CF9B6AAB012C2EBFACC21F8A80
2017/03/07 16:11:37 crypto.go:87: ------------------------------------------------------------
2017/03/07 16:11:37 crypto.go:89: data=		data to be signed!
2017/03/07 16:11:37 crypto.go:91: signature=		01a49114c81bc773faad33f3ba0cc82a05550d08434e2c1dd739b18f028d93fb494e2defc9f7e9b345fbfdd4ac5d95ffa0b6dc8a1b74d268eba4665ba3e8d22f0a
2017/03/07 16:11:37 crypto.go:94: signature again=		01a49114c81bc773faad33f3ba0cc82a05550d08434e2c1dd739b18f028d93fb494e2defc9f7e9b345fbfdd4ac5d95ffa0b6dc8a1b74d268eba4665ba3e8d22f0a
2017/03/07 16:11:37 crypto.go:97: Verify=		 true
```