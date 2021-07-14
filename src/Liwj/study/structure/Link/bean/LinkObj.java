package Liwj.study.structure.Link.bean;

/**
 * Created by Administrator on 2021/4/10.
 */
public class LinkObj {
    private Integer no;
    private LinkObj next;

    public LinkObj(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public LinkObj getNext() {
        return next;
    }

    public void setNext(LinkObj next) {
        this.next = next;
    }

}
