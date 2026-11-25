# Spring Mail Sender

Spring MVC ve `JavaMailSender` ile bir adres çağrısı üzerinden e-posta gönderen küçük örnek proje.

> **Not:** Bu depo 2017 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

Proje `Spring-Mail-Sender` klasöründedir.

- `conf/WebInitializer`, `WebConfig`, `ViewConfig` — `web.xml` kullanmadan Java ile Spring MVC kurulumu ve
  `JavaMailSenderImpl` tanımı
- `conf/MainConfEnum` — SMTP sunucu, port, kullanıcı ve şifre ayarları
- `service/MailService` — HTML gövdeli basit bir deneme e-postası gönderir
- `controller/RequestController` — `GET /sendmail/{alici}/{gonderen}` çağrısı e-postayı gönderir ve sonucu
  `mail.jsp` sayfasında gösterir

## Teknolojiler

- Java 8, Maven (`war` paketleme; kaynaklar `src/`, web içeriği `WebContent/` altında)
- Spring Framework 4.0.0 (Web MVC, context-support)
- JavaMail 1.4.3, Servlet 3.0, JSTL 1.2

## Çalıştırma

1. `MainConfEnum` içindeki sunucu, port, kullanıcı adı ve şifreyi kendi SMTP hesabınızın değerleriyle
   değiştirin (dosyada yalnızca örnek değerler vardır).
2. `Spring-Mail-Sender` klasörünü Eclipse'e **Existing Maven Project** olarak aktarın ya da `mvn package` ile
   `war` üretip Tomcat'e kurun.
3. Tarayıcıdan `/sendmail/alici@ornek.com/gonderen@ornek.com` adresini çağırın.
