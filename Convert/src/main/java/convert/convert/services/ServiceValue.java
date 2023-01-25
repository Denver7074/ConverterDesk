package convert.convert.services;
import convert.convert.enums.Course;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceValue {
    @SneakyThrows
    public static HashMap<String,String> getValue(){
        var doc = Jsoup.parse(new URL("https://cbr.ru/key-indicators/"),3000);
        var dollarValue = doc.select("td[class=value td-w-4 _bold _end mono-num _with-icon _up _red]").first().text();
        var euroValue = doc.select("td[class=value td-w-4 _bold _end mono-num _with-icon _down _green]").first().text();
        String rubValue = "1";
        List<String> listValue = List.of(rubValue, dollarValue, euroValue);
        List<Course> listKey = List.of(Course.values());
        HashMap<String,String> map = new HashMap<>();
        map.put(listKey.get(2).getLustName(), listValue.get(0));
        map.put(listKey.get(0).getLustName(), listValue.get(1));
        map.put(listKey.get(1).getLustName(),listValue.get(2));
        return map;
    }


}
