package pc.disease.entity;

/**
 * @Author: lazymxh
 * @ProjectName: PatientCommunication
 * @Package: IntelliJ IDEA
 * @Description:
 * @Since: 2022-04-08 19:07
 **/
public class cell {
    private String symname;
    private Integer num;

    public String getSymname() {
        return symname;
    }

    public void setSymname(String symname) {
        this.symname = symname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public cell(String symname, Integer num) {
        this.symname = symname;
        this.num = num;
    }

    @Override
    public String toString() {
        return "cell{" +
                "symname='" + symname + '\'' +
                ", num=" + num +
                '}';
    }
}
