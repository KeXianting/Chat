package com.chat.model.msg;

import javax.swing.JOptionPane;

import com.chat.main.ChatClient;
import com.chat.main.Server;

public class AcceptFriendMsg extends Msg {

	@Override
	public void process(ChatClient client) {
		if (client.getUser().equals(user)) {
			client.getUser().getFirends().add(targetUser);
			client.getUserListFrame().getUserListPanel().setUser(targetUser);
			JOptionPane.showMessageDialog(null, "�û�  " + targetUser.getName()
					+ " �ѳ�Ϊ���ĺ���");
		} else {
			client.getUser().getFirends().add(user);
			client.getUserListFrame().getUserListPanel().setUser(user);
			JOptionPane.showMessageDialog(null, "�û�  " + user.getName()
					+ " �ѳ�Ϊ���ĺ���");
		}
		client.getUserListFrame().getUserListPanel().rebuild();
	}

	@Override
	public void process(Server server) {
		server.getUserManager().addFriend(user, targetUser);
	}
}
