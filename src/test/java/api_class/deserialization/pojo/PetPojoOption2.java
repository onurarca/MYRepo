package api_class.deserialization.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetPojoOption2 {

    long id;
    CategoryPojo category;
    String name;
    List<String> photoUrls;
    //String status;
    List<TagsPojo> tags;






}
