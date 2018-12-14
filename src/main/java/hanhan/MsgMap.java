package hanhan;

import java.util.HashMap;
import java.util.Map;

/**
 *统一返回用map封装数据
 * */
public class MsgMap extends Msg {
    private Map data=new HashMap();

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }
}
