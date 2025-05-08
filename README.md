# ☁️ Upload de Arquivos com Java + Quarkus + AWS S3

![Java](https://img.shields.io/badge/Java-21-red?logo=java&logoColor=white)
![Quarkus](https://img.shields.io/badge/Quarkus-2.x-blue?logo=quarkus)
![AWS](https://img.shields.io/badge/AWS-EC2%20%7C%20S3-orange?logo=amazonaws)
![S3](https://img.shields.io/badge/S3-Bucket-yellow?logo=amazons3&logoColor=black)
![Docker](https://img.shields.io/badge/Docker-ready-blue?logo=docker)

Este projeto demonstra como criar uma aplicação Quarkus com Java que realiza **upload de arquivos para a AWS S3**, ideal para estudos e demonstrações no GitHub 🚀

---

## 📦 Tecnologias Utilizadas

- ☕ **Java 21**
- ⚡ **Quarkus 2.x**
- 🐳 **Docker**
- ☁️ **AWS EC2** – Instância para rodar a aplicação
- 📁 **AWS S3** – Armazenamento de arquivos

---

## 📁 Estrutura do Projeto

``` bash
aws-s3-upload/
│
├── src/
│ └── main/
│ └── java/
│ └── org.example/
│ └── service/
│ └── S3Service.java
│
├── resources/
│ └── application.properties
│
├── ec2-setup/
│ ├── install-java.sh
│ ├── install-docker.sh
│ └── run-app.sh
│
├── Dockerfile
├── README.md
└── pom.xml
```

---

## ⚙️ Configuração `application.properties`

```properties
aws.region=sa-east-1
aws.s3.bucket=my-demo-bucket
aws.access.key=SEU_ACCESS_KEY
aws.secret.key=SEU_SECRET_KEY
```

🔐 Dica: Use variáveis de ambiente para não expor suas credenciais no repositório.

☁️ Subindo o Projeto na EC2
Acesse sua instância EC2:


ssh -i sua-chave.pem ubuntu@<seu-ip>


Compile e execute:

``` bash ec2-setup/run-app.sh ```

Acesse a API:

http://<seu-ip>:8080/upload

📤 Upload de Arquivo – Exemplo de Endpoint

@POST
@Path("/upload")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response upload(@MultipartForm FileUploadForm form) {
    s3Service.upload(form.file);
    return Response.ok("Upload realizado com sucesso!").build();
}
📦 Dependência S3 no pom.xml
``` 
<dependency>
  <groupId>software.amazon.awssdk</groupId>
  <artifactId>s3</artifactId>
  <version>2.25.28</version>
</dependency>
``` 

📍 Região utilizada
Este exemplo utiliza a região:

sa-east-1  (América do Sul - São Paulo)

S3Client s3 = S3Client.builder()
    .region(Region.SA_EAST_1)
    .build();
🧪 Testando com Postman / curl

curl -F 'file=@/caminho/do/seu/arquivo.txt' http://<seu-ip>:8080/upload

💡 Possíveis Expansões
✅ Listar arquivos no bucket

✅ Fazer download

🔐 Autenticação com Cognito ou OAuth

📂 Organizar uploads por pasta/data

🛡️ Segurança
Nunca envie suas AWS_ACCESS_KEY e AWS_SECRET_KEY diretamente no código! Use .env, application.properties fora do versionamento ou serviços como AWS IAM Roles (em produção).

📘 Referências
SDK Java v2 - S3

Quarkus AWS Integration

AWS CLI Setup