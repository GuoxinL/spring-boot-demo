# Spring Boot Security

## 使用keytool生成数字证书

```
➜ keytool -genkey -keystore keystore.jks -alias tycoonclinet -keyalg RSA
   输入密钥库口令:  
   密钥库口令太短 - 至少必须为 6 个字符
   输入密钥库口令:  
   再次输入新口令: 
   您的名字与姓氏是什么?
     [Unknown]:  Guoxin Liu
   您的组织单位名称是什么?
     [Unknown]:  guoxin
   您的组织名称是什么?
     [Unknown]:  guoxin
   您所在的城市或区域名称是什么?
     [Unknown]:  Beijing
   您所在的省/市/自治区名称是什么?
     [Unknown]:  Beijing
   该单位的双字母国家/地区代码是什么?
     [Unknown]:  CN
   CN=Guoxin Liu, OU=guoxin, O=guoxin, L=Beijing, ST=Beijing, C=CN是否正确?
     [否]:  y
   
   输入 <tycoonclinet> 的密钥口令
   	(如果和密钥库口令相同, 按回车):  
   再次输入新口令: 
```
密钥库口令: 123456  
证书的别名: tycoonclinet  
证书文件名: keystore.jks  

## 引用
[重拾后端之Spring Boot（四）：使用JWT和Spring Security保护REST API](http://www.jianshu.com/p/6307c89fe3fa "悬停显示")  
[Java JWT: JSON Web Token for Java and Android](https://github.com/jwtk/jjwt "悬停显示")  
