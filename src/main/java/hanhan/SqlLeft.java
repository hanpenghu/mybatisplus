package hanhan;

public class SqlLeft {
    private String k=" ";
    private String d=",";
    private String as="AS";
    private String from="FROM";
    private String left="LEFT JOIN";
    private String  on="ON";
    private String where="WHERE";
    private String and="AND";
    private String or="OR";
    private StringBuffer sb=new StringBuffer("SELECT ");
    public static SqlLeft b(){
        return new SqlLeft();
    }

    public SqlLeft column(String column){
        sb.append(column).append(d);
        return this;
    }

    public SqlLeft column(String column,String asStr){
        sb.append(column).append(k).append(as).append(k).append(asStr).append(d);
        return this;
    }

    public SqlLeft column(String column,String nullToWhat,String asStr){
        sb.append("IFNULL(").append(column).append(",").append("'").append(nullToWhat).append("'").append(")").append(k).append(as).append(k).append(asStr).append(d);
        return this;
    }

    public SqlLeft from(){
        sb.append(from);
        return this;
    }

    public SqlLeft table(String tableName){
        sb.append(k).append(tableName);
        return this;
    }

    public SqlLeft table(String tableName,String alias){
        sb.append(k).append(tableName).append(k).append(alias).append(k);
        return this;
    }

    public SqlLeft left(String tableName,String alias){
        sb.append(left).append(k).append(tableName).append(k).append(alias);
        return this;
    }
    public SqlLeft left(String tableName,String alias,String condition){
        sb.append(left).append(k).append(tableName).append(k).append(alias).append(k).append(on).append(k).append(condition).append(k);
        return this;
    }

    public SqlLeft where(){
        sb.append(where).append(k);
        return this;
    }

    public SqlLeft where (String condition){
        sb.append(where).append(k).append(condition).append(k);
        return this;
    }

    public SqlLeft and(){
        sb.append(and).append(k);
        return this;
    }
    public SqlLeft and(String condition){
        sb.append(and).append(k).append(condition).append(k);
        return this;
    }
    public SqlLeft or(){
        sb.append(or).append(k);
        return this;
    }
    public SqlLeft or(String condition){
        sb.append(or).append(k).append(condition).append(k);
        return this;
    }
    public SqlLeft condition(String condition){
        sb.append("(").append(condition).append(")").append(k);
        return this;
    }

    public SqlLeft orderBy(String column){
        sb.append("ORDER BY").append(k).append(column).append(k);
        return this;
    }
    //正序
    public SqlLeft orderByAsc(String column){
        sb.append("ORDER BY").append(k).append(column).append(k).append("ASC").append(k);
        return this;
    }
    //倒序
    public SqlLeft orderByDESC(String column){
        sb.append("ORDER BY").append(k).append(column).append(k).append("DESC").append(k);
        return this;
    }
    public SqlLeft asc(){
        sb.append("ASC").append(k);
        return this;
    }
    public SqlLeft desc(){
        sb.append("DESC").append(k);
        return this;
    }

    public String g(){
        return sb.toString().replace("  "," ").replace("   "," ").replace("    "," ").replace(",FROM"," FROM");
    }



    public static void main(String[]args){
        String sql = SqlLeft.b()
                .column("AA1", "fuck","AA")
                .column("BB1", "BB")
                .from()
                .table("USER1","U1")
                .left("USER2","U2","U1.NAME=U2.NAME")
                .and().condition("U1.age=U2.age")
                .left("USER3","U3","U1.NAME=U3.NAME")
                .where().condition("U1.name='XXX' or U2.name='XXXX'")
                .orderByAsc("U1.age")
                .g();
        System.out.println(sql);
    }



}
