package Liwj.study.structure.Link.util;

import Liwj.study.structure.Link.bean.LinkHeader;
import Liwj.study.structure.Link.bean.LinkObj;

/**
 * Created by Administrator on 2021/4/10.
 */
public class LinkUtil {
    private LinkHeader linkHeader;

    public LinkUtil(LinkHeader linkHeader) {
        this.linkHeader = linkHeader;
    }

    public LinkHeader getLinkHeader() {
        return linkHeader;
    }

    public LinkHeader addLink(LinkObj linkObj) {
        if (linkHeader.getNext() == null) {
            linkHeader.setNext(linkObj);
            return linkHeader;
        } else {
            LinkObj curnode = linkHeader.getNext();
            if (curnode.getNext() == null) {
                curnode.setNext(linkObj);
                return linkHeader;
            }
            while (curnode.getNext() != null) {
                curnode = curnode.getNext();
            }
            curnode.setNext(linkObj);
            return linkHeader;
        }
    }

    public int getCountOfLink(LinkHeader linkHeader) {
        if (linkHeader.getNext() == null) {
            return 0;
        }
        int count = 1;
        LinkObj cur = linkHeader.getNext();
        while (cur.getNext() != null) {
            count++;
            cur = cur.getNext();
        }

        return count;
    }
    //链表翻转
    public LinkHeader reverseLink() {
        LinkHeader tmplink = new LinkHeader();
        if (linkHeader.getNext() == null || linkHeader.getNext().getNext() == null) {
            return linkHeader;
        }
        LinkObj curnode = linkHeader.getNext();
        LinkObj next = null;
        while (curnode != null) {
            next = curnode.getNext();
            curnode.setNext(tmplink.getNext());
            tmplink.setNext(curnode);
            curnode = next;
        }
        linkHeader.setNext(tmplink.getNext());
        tmplink = null;
        return linkHeader;

    }
    //获取倒数num
    public LinkObj getNode(int num) {
        if (linkHeader.getNext() == null || num < 1) {
            return null;
        }
        LinkObj conutobj1 = linkHeader.getNext();
        LinkObj getobj2 = linkHeader.getNext();
        while (conutobj1 != null) {
            conutobj1 = conutobj1.getNext();
            num --;
            if (num < 0){
                getobj2 = getobj2.getNext();
            }
        }
        return getobj2;
    }

}
