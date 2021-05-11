package api_class.deserialization.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PojoVerizonCustomerId {

    String id;
    String integrationCode;
    String type;
    boolean primary;
    String authenticatedState;

}
