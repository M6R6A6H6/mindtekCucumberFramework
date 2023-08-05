package utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAPITest2 {
    public static void main(String[] args) {


// GET REQUEST


        Response response =   given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept", "application/json")
                .when().get("/users/me/");

        System.out.println(response.statusCode());
        System.out.println(response.body().asString());


        //POST REQUEST

        Response postResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body(

                                "{\n" +
                                        "  \"company_name\": \"Ola\",\n" +
                                        "  \"company_type\": \"broker company\",\n" +
                                        "  \"status\": \"active\",\n" +
                                        "  \"mc_number\": \"973013809\",\n" +
                                        "  \"dot_number\": \"320018764\",\n" +
                                        "  \"ifta\": false,\n" +
                                        "  \"address\": \"576 diamond\",\n" +
                                        "  \"apt_suite_company_co\": null,\n" +
                                        "  \"city\": \"chicago\",\n" +
                                        "  \"state\": \"AL\",\n" +
                                        "  \"zip_code\": \"60505\",\n" +
                                        "  \"insurance\": \"MusaBosy\",\n" +
                                        "  \"producer_address\": \"587Beaumont\",\n" +
                                        "  \"producer_apt_suite_company_co\": null,\n" +
                                        "  \"producer_city\": \"naper\",\n" +
                                        "  \"producer_state\": \"AZ\",\n" +
                                        "  \"producer_zip_code\": \"60505\",\n" +
                                        "  \"policy_effective_day\": null,\n" +
                                        "  \"policy_expiration\": null,\n" +
                                        "  \"type_of_insurance\": null,\n" +
                                        "  \"automobile_liability\": \"\",\n" +
                                        "  \"num_of_truck_insured\": null,\n" +
                                        "  \"policy_number\": null,\n" +
                                        "  \"employer_id_num\": \"58-9176909\",\n" +
                                        "  \"billing_address\": null,\n" +
                                        "  \"bank_name\": null,\n" +
                                        "  \"routing_number\": null,\n" +
                                        "  \"account_number\": null,\n" +
                                        "  \"president_full_name\": null,\n" +
                                        "  \"trucks_in_fleet\": null,\n" +
                                        "  \"scac_code\": \"\",\n" +
                                        "  \"other_licenses\": false,\n" +
                                        "  \"license_name\": null,\n" +
                                        "  \"incorporated_in\": null,\n" +
                                        "  \"warning\": \"\",\n" +
                                        "  \"notes\": null,\n" +
                                        "  \"company_picture\": [],\n" +
                                        "  \"company_documents\": [],\n" +
                                        "  \"contacts\": [\n" +
                                        "    {\n" +
                                        "      \"phone\": \"154-456-1278\",\n" +
                                        "      \"ext\": \"\",\n" +
                                        "      \"contact_name\": \"\",\n" +
                                        "      \"email\": \"ghalahkhs@gmail.com\",\n" +
                                        "      \"fax\": \"\",\n" +
                                        "      \"producer_phone\": \"571-899-8879\",\n" +
                                        "      \"producer_phone_ext\": \"\",\n" +
                                        "      \"producer_contact_name\": \"\",\n" +
                                        "      \"producer_email\": \"fwusgmah@gmail.com\"\n" +
                                        "    }\n" +
                                        "  ],\n" +
                                        "  \"phone_number\": [\n" +
                                        "    {\n" +
                                        "      \"phone\": \"154-456-1278\",\n" +
                                        "      \"ext\": \"\",\n" +
                                        "      \"contact_name\": \"\",\n" +
                                        "      \"email\": \"ghalahkhs@gmail.com\",\n" +
                                        "      \"fax\": \"\",\n" +
                                        "      \"producer_phone\": \"571-899-8879\",\n" +
                                        "      \"producer_phone_ext\": \"\",\n" +
                                        "      \"producer_contact_name\": \"\",\n" +
                                        "      \"producer_email\": \"fwusgmah@gmail.com\"\n" +
                                        "    }\n" +
                                        "  ],\n" +
                                        "  \"fax_number\": [\n" +
                                        "    {\n" +
                                        "      \"fax\": \"\"\n" +
                                        "    }\n" +
                                        "  ],\n" +
                                        "  \"email_number\": [\n" +
                                        "    {\n" +
                                        "      \"email\": \"ghalahkhs@gmail.com\"\n" +
                                        "    }\n" +
                                        "  ],\n" +
                                        "  \"producer_email_number\": [\n" +
                                        "    {\n" +
                                        "      \"producer_email\": \"fwusgmah@gmail.com\"\n" +
                                        "    }\n" +
                                        "  ],\n" +
                                        "  \"producer_phone_number\": [\n" +
                                        "    {\n" +
                                        "      \"producer_phone\": \"571-899-8879\",\n" +
                                        "      \"producer_phone_ext\": \"\",\n" +
                                        "      \"producer_contact_name\": \"\"\n" +
                                        "    }\n" +
                                        "  ]\n" +
                                        "}")       .when().post("/companies/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());

//PATCH/UPDATE REQUEST
        Response updateResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body(
                "{\n" +
                        "  \"id\": 150,\n" +
                        "  \"alert\": [],\n" +
                        "  \"company_name\": \"ZRGMTestersA\",\n" +
                        "  \"company_type\": \"broker company\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"mc_number\": \"123456789\",\n" +
                        "  \"dot_number\": \"1234567\",\n" +
                        "  \"ifta\": false,\n" +
                        "  \"address\": \"123445\",\n" +
                        "  \"apt_suite_company_co\": null,\n" +
                        "  \"city\": \"Naperville\",\n" +
                        "  \"state\": \"IL\",\n" +
                        "  \"zip_code\": \"60404\",\n" +
                        "  \"insurance\": \"Bidheifbsd\",\n" +
                        "  \"producer_address\": \"4564788869\",\n" +
                        "  \"producer_apt_suite_company_co\": null,\n" +
                        "  \"producer_city\": \"illinois\",\n" +
                        "  \"producer_state\": \"IL\",\n" +
                        "  \"producer_zip_code\": \"60404\",\n" +
                        "  \"policy_effective_day\": null,\n" +
                        "  \"policy_expiration\": null,\n" +
                        "  \"type_of_insurance\": null,\n" +
                        "  \"automobile_liability\": \"\",\n" +
                        "  \"num_of_truck_insured\": null,\n" +
                        "  \"policy_number\": null,\n" +
                        "  \"billing_address\": null,\n" +
                        "  \"bank_name\": null,\n" +
                        "  \"routing_number\": null,\n" +
                        "  \"account_number\": null,\n" +
                        "  \"president_full_name\": null,\n" +
                        "  \"trucks_in_fleet\": null,\n" +
                        "  \"scac_code\": \"\",\n" +
                        "  \"other_licenses\": false,\n" +
                        "  \"license_name\": null,\n" +
                        "  \"incorporated_in\": null,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": null,\n" +
                        "  \"contacts\": [\n" +
                        "    {\n" +
                        "      \"phone\": \"123-456-7789\",\n" +
                        "      \"contact_name\": \"\",\n" +
                        "      \"ext\": \"1234\",\n" +
                        "      \"email\": \"testers56@gmail.com\",\n" +
                        "      \"fax\": \"\",\n" +
                        "      \"producer_phone\": \"328-676-3687\",\n" +
                        "      \"producer_contact_name\": \"\",\n" +
                        "      \"producer_phone_ext\": \"\",\n" +
                        "      \"producer_email\": \"bidheifbsd@gmail.com\",\n" +
                        "      \"id\": 151\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}") .when().patch("/companies/150/");
        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());



    }
}
