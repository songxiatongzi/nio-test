package com.example.nio.niotest.niotest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.concurrent.TimeUnit;

/**
 *  44
 * netty tcp 快速入门
 * 	编写客户端  
 * 	编写服务端 netty-server
 * @author Administrator
 *
 */
public class NettyTcpTest01 {

	/**
	 * 	netty-server
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// 创建了两个线程组 
		// bossGroup 只处理链接请求
		// 真正和客户端进行业务处理的，会交给workGroup
		// 两个都是无限循环
		/*
		 * NioEventLoopGroup  selector  taskQueue
		 * taskQueue 和channel 有一个绑定的关系
		 * task 有三种典型的使用场景
		 * 		1.
		 * 将一些比较耗时的任务放到 taskQueue 中取处理
		 */
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup worksGroup = new NioEventLoopGroup();
		
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		
		// 使用链式编程进行设置
		/*
		 * public B channel(Class<? extends C> channelClass) {
        return channelFactory(new ReflectiveChannelFactory<C>(
                ObjectUtil.checkNotNull(channelClass, "channelClass")
        ));
    }
		 */
		serverBootstrap.group(bossGroup, worksGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 128)//设置线程的连接个数
				.childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动连接的状态
				.childHandler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel ch) throws Exception {
				// TODO Auto-generated method stub
				// 这是一个双向列表 pipeline
				// pipeline 和 channel 是相互包含的关系  ctx 则是包含更多的信息，包括pipeline 和 channel

				ch.pipeline().addLast(null);
			}
		
		});
		
		// 绑定一个接口并且同步，生成一个ChannelFuture 对象
		ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();
		
		// 对关闭通道进行监听
		channelFuture.channel().closeFuture().sync();

	}
}
