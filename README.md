# 🌐 ApiTestAutomationWithTestNG

Bu repository, **Java** dili kullanılarak geliştirilmiş, **Rest-Assured + TestNG** tabanlı **REST API test otomasyonu** örneklerini içermektedir.  
Proje; farklı HTTP metodları, JSON doğrulamaları, POJO modelleme ve TestNG yapısı ile uçtan uca API test senaryolarının nasıl kurgulanacağını öğretmeyi amaçlayan kapsamlı bir eğitim ve pratik çalışmasıdır.

Testler; gerçek servisler üzerinde GET, POST, PUT ve DELETE işlemleri ile response doğrulamaları yapacak şekilde senaryolaştırılmıştır.

---

## 🎯 Projenin Amacı

- REST API servislerini otomasyon ile test etmek  
- HTTP metodlarının (GET, POST, PUT, DELETE) kullanımını öğrenmek  
- Response body ve status code doğrulamaları yapmak  
- JSONPath ile alan bazlı doğrulama gerçekleştirmek  
- POJO sınıfları ile serialization & deserialization işlemlerini kavramak  
- TestNG ile organize edilmiş test yapısı oluşturmak  

---

## 🛠️ Kullanılan Teknolojiler ve Araçlar

| Teknoloji | Açıklama |
|----------|----------|
| **Java 17** | Test otomasyon dili |
| **Rest-Assured** | REST API test otomasyonu |
| **TestNG** | Test yönetimi ve assertion yapısı |
| **Gson** | JSON ↔ Java dönüşümleri |
| **org.json** | JSON objesi oluşturma ve işleme |
| **Maven** | Proje bağımlılık yönetimi |
| **IntelliJ IDEA** | Geliştirme ortamı (IDE) |

---

## 📦 Bağımlılıklar (pom.xml)

Projede kullanılan temel kütüphaneler:

- Rest-Assured → API testlerini gerçekleştirmek için  
- TestNG → Test senaryolarını çalıştırmak ve organize etmek için  
- Gson → Serialization & Deserialization işlemleri için  
- org.json → JSON objesi oluşturma ve yönetme işlemleri için  
- JUnit → Yardımcı test anotasyonları (test scope)  

---

## 📁 Proje Yapısı

```ApiTestAutomationWithTestNG/
├── .idea/
├── src/
│ └── test/
│     └── java/
│         ├── baseUrl/                # API endpoint base URL yapılandırmaları
│         │   ├── BaseUrlDummyExample.java
│         │   ├── BaseUrlHerokuapp.java
│         │   └── BaseUrlJsonPlaceholder.java
│         │
│         ├── pojos/                  # Request/Response body için POJO sınıfları
│         │   ├── pojosHavaDurumu/
│         │   ├── PojoDummyExampleData.java
│         │   ├── PojoDummyExampleResponse.java
│         │   ├── PojoHerokuappBookingdates.java
│         │   ├── PojoHerokuappRequestBody.java
│         │   ├── PojoHerokuappResponseBody.java
│         │   └── PojoJsonPlaceholder.java
│         │
│         ├── testDatalari/           # Testlerde kullanılan statik/dinamik test verileri
│         │   ├── TestDataDummyExample.java
│         │   ├── TestDataHerokuapp.java
│         │   └── TestDataJsonPlaceholder.java
│         │
│         └── tests/                  # Tüm API test senaryoları
│             ├── C01_GetRequest_ResponseBodyYazdirma.java
│             ├── C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi.java
│             ├── C03_Get_ResponseDegerleriniOtomasyonIleTestEtme.java
│             ├── C04_JsonObjesiOlusturma.java
│             ├── C05_JsonObjesiOlusturma.java
│             ├── C06_Put_ResponseBilgileriAssertion.java
│             ├── C07_Get_ResponseBodyTesti.java
│             ├── C08_Post_ResponseBodyTesti.java
│             ├── C09_Get_TestYaparkenTekrarlardanKurtulma.java
│             ├── C10_JsonPathKullanimi.java
│             ├── C11_Post_JsonPathIleBodyTesti.java
│             ├── C12_Get_ResponseBodyTestiListKullanimi.java
│             ├── C13_Get_ExpectedDataOlusturma.java
│             ├── C14_Post_ExpectedDataVeJsonPathIleAssertion.java
│             ├── C15_Get_SoftAssertIleExpectedDataTesti.java
│             ├── C16_Put_SoftAssertIleExpectedDataTesti.java
│             ├── C17_BaseUrlJsonPlaceholderRestapi.java
│             ├── C18_BaseUrlHerokuapp.java
│             ├── C19_BaseUrlHerokuappQueryParam.java
│             ├── C20_Get_TestDataClassKullanimi.java
│             ├── C21_Get_TestDataClassKullanimiDinamik.java
│             ├── C22_Put_TestDataClassKullanimi.java
│             ├── C23_Get_TestDataKullanimi.java
│             ├── C24_Post_TestDataKullanimi.java
│             ├── C25_Put_DeSerialization.java
│             ├── C26_Get_DeSerialization.java
│             ├── C27_Post_Deserialization.java
│             ├── C28_Put_PojoClass.java
│             ├── C29_Post_Pojo.java
│             ├── C30_Get_Pojo.java
│             └── C31_Post_Pojo.java
│
├── pom.xml
├── .gitignore
└── README.md
```
---

## 🧪 Test Yapısı ve Mantığı

* Testler Rest-Assured + TestNG kullanılarak yazılmıştır
* Her sınıf belirli bir endpoint veya test senaryosuna odaklanır
* JSON response’lar:
   * JSONPath
   * POJO deserialization
   * SoftAssert / HardAssert kullanılarak doğrulanır
* Projede uygulanan başlıca senaryolar:
* GET request ile veri çekme ve doğrulama
* POST request ile veri oluşturma testleri
* PUT request ile güncelleme testleri
* JSON objesi oluşturma ve gönderme
* TestData class kullanarak dinamik veri üretimi
* Serialization & Deserialization işlemleri
* SoftAssert ile çoklu doğrulamalar

---

 ## ▶️ Projeyi Çalıştırma Adımları

1. Repository'i klonlayın:
```
git clone https://github.com/kilicCeren/ApiTestAutomationWithTestNG.git
```
2. IntelliJ IDEA ile projeyi açın

3. Maven bağımlılıklarını yükleyin:
```
mvn clean install
```
4. Tüm testleri çalıştırmak için:
```
mvn test
```
5. İsterseniz belirli bir test sınıfını IDE üzerinden çalıştırabilirsiniz.

---

## 📝 Lisans
Bu proje kişisel eğitim ve portföy amaçlıdır.
API test otomasyonu üzerine edindiğim bilgileri uygulamalı olarak pekiştirdiğim bir çalışmadır.

---

# 🌐 ApiTestAutomationWithTestNG

This repository contains **REST API test automation** examples based on **Rest-Assured + TestNG**, developed using the **Java** programming language.  
The project is a comprehensive educational and practical study that aims to teach how to design end-to-end API test scenarios with different HTTP methods, JSON validations, POJO modeling, and a structured TestNG architecture.

Tests are scenario-based to perform response validations on real services using GET, POST, PUT, and DELETE operations.

---

## 🎯 Project Purpose

- Automate testing of REST API services  
- Learn the usage of HTTP methods (GET, POST, PUT, DELETE)  
- Perform response body and status code validations  
- Implement field-based validations using JSONPath  
- Understand serialization & deserialization processes with POJO classes  
- Create an organized test structure with TestNG

---

## 🛠️ Technologies and Tools Used

| Technology | Description |
|----------|----------|
| **Java 17** | Test automation language |
| **Rest-Assured** | REST API test automation |
| **TestNG** | Test management and assertion structure |
| **Gson** | JSON ↔ Java conversions |
| **org.json** | JSON object creation and processing |
| **Maven** | Project dependency management |
| **IntelliJ IDEA** | Development environment (IDE) |

---

## 📦 Dependencies (pom.xml)

Main libraries used in the project:

- Rest-Assured → For performing API tests  
- TestNG → For executing and organizing test scenarios  
- Gson → For serialization & deserialization operations  
- org.json → For creating and managing JSON objects  
- JUnit → Helper test annotations (test scope)  

---

## 📁 Project Structure

```ApiTestAutomationWithTestNG/
├── .idea/
├── src/
│ └── test/
│     └── java/
│         ├── baseUrl/                # Base URL configurations for API endpoints
│         │   ├── BaseUrlDummyExample.java
│         │   ├── BaseUrlHerokuapp.java
│         │   └── BaseUrlJsonPlaceholder.java
│         │
│         ├── pojos/                  # POJO classes for request/response bodies
│         │   ├── pojosHavaDurumu/
│         │   ├── PojoDummyExampleData.java
│         │   ├── PojoDummyExampleResponse.java
│         │   ├── PojoHerokuappBookingdates.java
│         │   ├── PojoHerokuappRequestBody.java
│         │   ├── PojoHerokuappResponseBody.java
│         │   └── PojoJsonPlaceholder.java
│         │
│         ├── testDatalari/           # Static/dynamic test data used in tests
│         │   ├── TestDataDummyExample.java
│         │   ├── TestDataHerokuapp.java
│         │   └── TestDataJsonPlaceholder.java
│         │
│         └── tests/                  # All API test scenarios
│             ├── C01_GetRequest_ResponseBodyYazdirma.java
│             ├── C02_GetRequest_ResponseBilgilerininManuelTestEdilmesi.java
│             ├── C03_Get_ResponseDegerleriniOtomasyonIleTestEtme.java
│             ├── C04_JsonObjesiOlusturma.java
│             ├── C05_JsonObjesiOlusturma.java
│             ├── C06_Put_ResponseBilgileriAssertion.java
│             ├── C07_Get_ResponseBodyTesti.java
│             ├── C08_Post_ResponseBodyTesti.java
│             ├── C09_Get_TestYaparkenTekrarlardanKurtulma.java
│             ├── C10_JsonPathKullanimi.java
│             ├── C11_Post_JsonPathIleBodyTesti.java
│             ├── C12_Get_ResponseBodyTestiListKullanimi.java
│             ├── C13_Get_ExpectedDataOlusturma.java
│             ├── C14_Post_ExpectedDataVeJsonPathIleAssertion.java
│             ├── C15_Get_SoftAssertIleExpectedDataTesti.java
│             ├── C16_Put_SoftAssertIleExpectedDataTesti.java
│             ├── C17_BaseUrlJsonPlaceholderRestapi.java
│             ├── C18_BaseUrlHerokuapp.java
│             ├── C19_BaseUrlHerokuappQueryParam.java
│             ├── C20_Get_TestDataClassKullanimi.java
│             ├── C21_Get_TestDataClassKullanimiDinamik.java
│             ├── C22_Put_TestDataClassKullanimi.java
│             ├── C23_Get_TestDataKullanimi.java
│             ├── C24_Post_TestDataKullanimi.java
│             ├── C25_Put_DeSerialization.java
│             ├── C26_Get_DeSerialization.java
│             ├── C27_Post_Deserialization.java
│             ├── C28_Put_PojoClass.java
│             ├── C29_Post_Pojo.java
│             ├── C30_Get_Pojo.java
│             └── C31_Post_Pojo.java
│
├── pom.xml
├── .gitignore
└── README.md
```

---


