#

## 生成ssl证书
```bash
keytool -genkey -alias undertow -storetype PKCS12 -keyalg RSA  -keypass 123456 -keysize 1024 -validity 365 -keystore keystore.p12 -storepass 123456
您的名字与姓氏是什么?
  [Unknown]:
您的组织单位名称是什么?
  [Unknown]:
您的组织名称是什么?
  [Unknown]:
您所在的城市或区域名称是什么?
  [Unknown]:
您所在的省/市/自治区名称是什么?
  [Unknown]:
该单位的双字母国家/地区代码是什么?
  [Unknown]:
CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown是否正确?
  [否]:  y

```