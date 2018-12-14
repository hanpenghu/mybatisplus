package hanhan;
import java.util.*;

/**
 *首先set  currentPage---前端穿过来
 *
 * 再set  perPageSize-----前端穿过来,不传默认写死10
 *
 * 再set   totalRecSize-------查数据库的总记录数,此时顺便把totalPageSize(总页数)也设置了
 *
 *
 *
 *
 * */
public class PageHan {
    //当前页
    private Integer pageNum=null;//当前页的页面传过来
    //每页显示数
    private Integer pageSize=10;

    //总记录数
    private Long total=null;

    //总页数
    private Integer pages=null;

    //装一些实体数据
    private List<?extends Object> objList=new LinkedList<>();
    //装数据对象
    private List<String> strList=new LinkedList<String>();

    private List<Map<String,String>>mapStrList=new LinkedList<Map<String,String>>();

    private Map<String,String>map=new LinkedHashMap<String,String>();




//    public static void main(String[]args){
//            PageHan pageHan=new PageHan();
//            pageHan.setPageNum(1);
//            //设置每页显示数和总记录数,就会自动计算 pages 总页数
//            pageHan.setPageSize(10).setTotal(1000);
//            /**
//                         {
//                             "pageNum":1,
//                             "pageSize":10,
//                             "pages":100,
//                             "total":1000
//                         }
//             * */
//            System.out.println(JSON.toJSONString(pageHan, SerializerFeature.PrettyFormat));
//
//    }





    //设置当前页码
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    //得到当前页码
    public Integer getPageNum() {
        return pageNum;
    }





    //设置每页显示数
    public PageHan setPageSize(Integer pageSize) {
        if(empty(pageSize)||pageSize==0){
            pageSize=10;
        }
        this.pageSize = pageSize;
        //顺便把总页数也设置一下
        this.setPages();
        return this;
    }




    //得到每页显示数
    public Integer getPageSize() {
        if(empty(pageSize)||pageSize==0){
            pageSize=10;
        }
        return pageSize;
    }








    //得到总记录数
    public long getTotal() {

        return total;

    }

    //设置总记录数,顺便把总页数计算了
    public PageHan setTotal(long total) {
        this.total = total;
        //顺便把总页数也设置一下
        this.setPages();
        return this;
    }


    //设置总页数,不用设置了,在设置总记录数的时候已经设置了
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    //得到总页数
    public Integer getPages() {
        this.setPages();
        return this.pages;
    }

    public void setPages() {
        this.pageSize=this.getPageSize();
        if(this.total%this.pageSize==0){
            this.pages=(int)(this.total/this.pageSize);
        }else{
            this.pages=(int)(this.total/this.pageSize+1);
        }
    }


    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }




    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<Map<String, String>> getMapStrList() {
        return mapStrList;
    }

    public void setMapStrList(List<Map<String, String>> mapStrList) {
        this.mapStrList = mapStrList;
    }


    public List<? extends Object> getObjList() {
        return objList;
    }

    public void setObjList(List<? extends Object> objList) {
        this.objList = objList;
    }

    /**
     *以下是空判断和非空判断以及所有非空判断和所有空的判断,如果是包含空的
     * 判断请用   !allNotEmpty
     * */

    private  boolean empty(Object ob){

        if(notEmpty(ob)){
            return false;
        }else{
            return true;
        }

    }




    private boolean notEmpty(Object ob){
        if(ob==null){
            return false;
        }else{
            if(ob instanceof String){
                if("".equals(ob)){return false;}else{return true;}
            }else if(ob instanceof Collection){
                if(((Collection) ob).size()>0){return true;}else{return false;}
            }else if(ob instanceof Map){
                if(((Map) ob).size()>0){return true;}else{return false;}
            }/*else if(ob instanceof JSONObject){
                if(((JSONObject) ob).isEmpty()){return false;}else{
                    if(((JSONObject) ob).size()==0){return false;}else{return true;}
                }
            }else if(ob instanceof JSONArray){
                if(((JSONArray) ob).isEmpty()){return false;}else{
                    if(((JSONArray) ob).size()==0){return false;}else{return true;}
                }
            }*/else{return true;}
        }
    }

    //所有的非空
    private boolean allNotEmpty(Object[ ]obs){
        for(Object ob:obs){
            if(!notEmpty(ob)){return false;}
        }
        return true;
    }

    //不是所有的是空的,有不为空的
    private boolean notAllEmpty(Object[ ]obs){
        int i=0;
        for(Object ob:obs){
            if(notEmpty(ob)){i++;}
        }
        if(i>0){
            return true;
        }else{
            return false;
        }

    }
    //测试notAllEmpty
//    public static void main(String[]args){
//           p.p(notAllEmpty(p.gp().setArl("1").setArl(null).getArl().toArray()));
//    }

    private boolean allEmpty(Object[ ]obs){
        for(int i=1;i<=obs.length;i++){
            /**
             *循环所有,如果有一个不是空的,就代表有不是空的,不是所有是空的,返回false
             * */
            if(notEmpty(obs[i])){
                return false;
            }
            /**
             *如果到了最后一个,也是空的,就返回true,代表所有的都空了
             * */
            if(empty(obs[i])&&i==obs.length){
                return true;
            }
        }
        return false;
    }



}
