package com.base.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShellCommandUtils {

    private static  Logger logger = LoggerFactory.getLogger(ShellCommandUtils.class);

    /**
     * 连接sftp服务器
     * @param host 远程主机ip地址
     * @param port sftp连接端口，null 时为默认端口
     * @param user 用户名
     * @param password 密码
     * @return
     * @throws JSchException
     */
    public static Session connect(String host, Integer port, String user, String password) throws JSchException {
        Session session = null;
        try {
            JSch jsch = new JSch();
            if(port != null){
                session = jsch.getSession(user, host, port.intValue());
            }else{
                session = jsch.getSession(user, host);
            }
            session.setPassword(password);
            //设置第一次登陆的时候提示，可选值:(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            //30秒连接超时
            session.connect(30000);
        } catch (JSchException e) {
            e.printStackTrace();
            logger.error("SSH获取连接发生错误",e);
            throw e;
        }
        return session;
    }

}
