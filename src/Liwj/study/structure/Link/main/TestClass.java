package Liwj.study.structure.Link.main;

import Liwj.study.structure.Link.bean.LinkHeader;
import Liwj.study.structure.Link.bean.LinkObj;
import Liwj.study.structure.Link.util.LinkUtil;

/**
 * Created by Administrator on 2021/4/10.
 */
public class TestClass {
    public static void main(String[] args) {
        LinkUtil util = new LinkUtil(new LinkHeader());
        LinkObj obj1 = new LinkObj(0);
        LinkObj obj2 = new LinkObj(1);
        LinkObj obj3 = new LinkObj(2);
        LinkObj obj4 = new LinkObj(4);
        LinkObj obj5= new LinkObj(5);
        util.addLink(obj1);
        util.addLink(obj2);
        util.addLink(obj3);
        util.addLink(obj4);
        util.addLink(obj5);

        System.out.println(util.getCountOfLink(util.getLinkHeader()));
        LinkHeader reverselinkHeader = util.reverseLink();


        LinkObj result = util.getNode(4);

        System.out.println("finish");
    }
}
