package Utils;

public class PayloadUtils {

    public static String getSlackMessagePayload(String message){

        String messagePayload = "{\n" +
                "    \"channel\": \"C01GEQL1GNQ\",\n" +
                "    \"text\": \""+message+"\" \n" +
                "    \n" +
                "}";
        return messagePayload;

    }


    public static String getPetStorePayload(int id, String name, String status) {

        String messagePayload = "{\n" +
                "  \"id\": "+id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \""+status+"\"\n" +
                "}";

        return messagePayload;


    }

    public static String getJiraStoryPayload(String summary, String description,String issueType){

        return "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"TEC\"\n" +
                "        }, \n" +
                "        \"summary\": \""+summary+"\",\n" +
                "        \"description\": \""+description+"\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \""+issueType+"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

    }

    public static String getJiraAuthPayload(){

        return "{\n" +
                "    \"username\": \""+PropertyReader.readPropertyByKey("username2")+"\",\n" +
                "    \"password\": "+PropertyReader.readPropertyByKey("password2")+"\n" +
                "}";

    }
}
