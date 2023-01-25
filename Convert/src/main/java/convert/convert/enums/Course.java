package convert.convert.enums;

import convert.convert.services.ServiceValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum Course {
    Dollar("Доллар"),
    Euro("Евро"),
    RUB("Рубль");

    private final String lustName;


}
