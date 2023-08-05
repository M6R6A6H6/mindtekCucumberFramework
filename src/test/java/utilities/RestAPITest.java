package utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class RestAPITest {
    public static void main(String[] args) {

        /**
         * Make get yard api call.
         * Request(url. BaseUrld, Endpoint) and Autorization, Accept (application/json)
         * and Method(get)
         * response.
         * 1.
         */

      Response response =   given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept", "application/json")
                .when().get("/yards/18/");

    System.out.println(response.statusCode());
       System.out.println(response.body().asString());


        /**
         * Post call
         * Request:
         * 1.Url-> BaseUrl +Endpoint
         * Headers -> Authorization (token), Content_Type(application/json),Accept(application/jyson)
         * Payload/Body-> json
         * ---------------
         * Response
         * 1.Status code->201
         * 2. Body -> json
         *
         */

        Response postResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"location\": \"Arslan3\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"123 Mindtek Rd\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60173\",\n" +
                        "  \"spots\": \"123\",\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"yard_picture\": [],\n" +
                        "  \"contacts\": [],\n" +
                        "  \"service_phone_number\": [\n" +
                        "    {\n" +
                        "      \"service_phone\": \"\",\n" +
                        "      \"service_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"owner_phone_number\": [\n" +
                        "    {\n" +
                        "      \"owner_phone\": \"\",\n" +
                        "      \"owner_contact_name\": \"\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when().post("/yards/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());


        /**
         * Patch call:
         * 1.Url-> BaseUrl+Endpoint
         * Headers-> authorization(Token) Accept(application/json) Content_type(application/json)
         * 3.Payload_> json
         * 4.Method->Patch
         * Response
         * Status_
         *
         */
        Response updateResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 70,\n" +
                        "  \"location\": \"Tony cat12\",\n" +
                        "  \"name\": \"Y70\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"123445\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Chicago\",\n" +
                        "  \"state\": \"AL\",\n" +
                        "  \"zip_code\": \"60404\",\n" +
                        "  \"spots\": 123,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": []\n" +
                        "}")
                .when().patch("/yards/40/");
        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());

 }
}
