package pub.guoxin.websocket.javax;

/**
 * Create by guoxin on 2018/4/25
 */

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ServerEndpoint
 * <p>
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，但在springboot中连容器都是spring管理的。
 * <p>
 * 虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
 *
 * @author sam
 * @since 2017/9/13
 */
@Component
@ServerEndpoint(value = "/ws/chat/{username}") //WebSocket客户端建立连接的地址
public class ChatRoomServerEndpoint {

    /**
     * 存活的session集合（使用线程安全的map保存）
     */
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    /**
     * 建立连接的回调方法
     *
     * @param session  与客户端的WebSocket连接会话
     * @param username 用户名，WebSocket支持路径参数
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        String id = session.getId();
        System.out.println("id" + id);
        livingSessions.put(id, session);
        sendMessageToAll(username + " 加入聊天室");
    }

    /**
     * 收到客户端消息的回调方法
     *
     * @param message 客户端传过来的消息
     * @param session 对应的session
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String username) {
        sendMessageToAll(username + " : " + message);
    }


    /**
     * 发生错误的回调方法
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 关闭连接的回调方法
     */
    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        livingSessions.remove(session.getId());
        sendMessageToAll(username + " 退出聊天室");
    }


    /**
     * 单独发送消息
     *
     * @param session
     * @param message
     */
    public void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     *
     * @param message
     */
    public void sendMessageToAll(String message) {
        livingSessions.forEach((sessionId, session) -> {
            sendMessage(session, message);
        });
    }

}
