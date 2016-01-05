package com.chat.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.chat.main.ChatClient;
import com.chat.model.User;

public class UserInfoFrame extends JFrame {

	public static final int FRAME_WIDTH = 600;
	public static final int FRAME_HEIGHT = 500;

	private User user;

	public UserInfoFrame(User user) {
		super("������Ϣ�޸�");
		this.user = user;
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		init();
		this.setVisible(true);
	}

	public void init() {
		if (user == null) {
			user = ChatClient.getInstance().getUser();
		}

		JTabbedPane tp = new JTabbedPane(JTabbedPane.LEFT);
		this.add(tp, BorderLayout.CENTER);

		tp.add("������Ϣ", new UserInfoPanel(this));
		if (user.equals(ChatClient.getInstance().getUser())) {
			tp.add("�޸�����", new PasswordPanel(this));
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}