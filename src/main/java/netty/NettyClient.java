package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Create by xuantang
 * @date on 9/10/18
 */
public class NettyClient {

    public void run() {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel s) {
                        s.pipeline().addLast("decode", new StringDecoder())
                                .addLast("encode", new StringEncoder())
                                .addLast("http", new HttpClientCodec())
                                .addLast("chat", new SimpleChannelInboundHandler<String>() {
                                    @Override
                                    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
                                        System.out.println("From Server: " + s);
                                    }
                                });
                    }
                });

        try {
            Channel channel = bootstrap.connect("localhost", 9999).sync().channel();

            channel.writeAndFlush("Hello");

            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NettyClient().run();
    }
}
