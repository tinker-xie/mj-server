package com.xie.mina.core;

/**
 * @Author xie
 * @Date 17/2/15 下午12:13.
 */

public class NetManager {

    // 协议命令
    public static final int CMD_HOST_REQUEST_ROOM = 10001;
    public static final int CMD_REPLY_ROOM = 10002;
    public static final int CMD_CREATE_ROOM = 10003;
    public static final int CMD_HOST_JOIN_ROOM = 10004;
    public static final int CMD_BROAD_USERLIST = 10005;
    public static final int CMD_UPDATE_ROOM = 10006;
    public static final int CMD_HOST_LEAVE_ROOM = 10007;
    public static final int CMD_LEAVE_ROOM = 10008;
    public static final int CMD_DEL_ROOM = 10009;
    public static final int CMD_HOST_READY_ROOM = 10010;
    public static final int CMD_BEGIN_CARDS = 10011;
    public static final int CMD_HOST_FINISH_LANDLORD = 10012;
    public static final int CMD_BROAD_NEXT_LANDLORD = 10013;
    public static final int CMD_BEGIN_LANDLORD_CARDS = 10014;
    public static final int CMD_HOST_START_CARDS = 10015;
    public static final int CMD_START_CARDS = 10016;
    public static final int CMD_HOST_SEND_CARDS = 10017;
    public static final int CMD_SEND_CARDS = 10018;
    public static final int CMD_SEND_CURRENTID_CARDS = 10019;
    public static final int CMD_HOST_SEND_CARDS_COMPUTER = 10020;

    public static final int MSG_USER_LOGIN = 20000;
    public static final int MSG_USER_LOGOUT = 20001;
    public static final int MSG_UPDATE_ROOM = 20002;
    public static final int MSG_UPDATE_User = 20002;
    public static final int MSG_UPDATE_BEGINCARD = 20003;
    public static final int MSG_UPDATE_LANDLORD = 20004;
    public static final int MSG_SHOW_CARDBUTTON = 20005;
    public static final int MSG_UPDATE_LANDLORDHEAD = 20006;
    public static final int MSG_SEND_CARDS = 20007;
    public static final int MSG_FLUSH_CARDS = 20008;


    public static final String SERVER_HOST = "127.0.0.1";// 服务器
    public static final int SERVER_PORT = 9001;// 发送端口
    public static final int LOCAL_PORT = 2345;// 接收端口


}

