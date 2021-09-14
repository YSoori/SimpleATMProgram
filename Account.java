package C0901_Practice_Acc;

public class Account {
	String acc, name, pw; // ���¹�ȣ, �̸�,��й�ȣ
	int nowMoney, money=0; //�ܰ�, ����ݿ� ����� ��
	int minusLine; //���̳ʽ� ����
	
	
	//������ ���¹�ȣ, �̸�, ��й�ȣ, �ݾ��� �Է¹ް� �ʱ�ȭ�� ��.
	public Account(String acc, String name, String pw, int nowMoney) {
		this.acc = acc;
		this.name = name;
		this.pw = pw;
		this.nowMoney = nowMoney;
	}
	
	//������ ������ �ݾ��� �Է¹��� ������ �ݾ��� 0���� �����Ѵ�.
	public Account(String acc, String name, String pw) {
		this(acc, name, pw, 0);
	}
	
	//�Ա� �޼ҵ�
	public int credit(int money) {
		return this.nowMoney+=money; 
	}
	
	//��� �޼ҵ�, ��й�ȣ�� �����ݾ��� �Ű������� �ް� Ȯ�� �� ��� ���� or ����ó��.
	public int debit(String pw, int money) {
		if(this.pw.equals(pw)) {
			if(this.nowMoney-money>=0) {
				return this.nowMoney-=money;
			}else {
				System.out.println("�ܾ��� �����մϴ�.");
			}
		}else {
			System.out.println("�߸��� ��й�ȣ �Դϴ�.");
		}
		
		return 0;
	}
	
	//�۱� �޼ҵ�, �������, ��й�ȣ, �����ݾ��� �Ű������� �޾ƿ�
	//������¿� ��й�ȣ Ȯ�� �� �޼ҵ� ���� or ����ó��
	public boolean send(Account sendAcc, String pw, int money) {
		int result = this.debit(pw, money);
		if(result!=0) {
			sendAcc.credit(money);
			return true;
		}
		return false;
	}
	
	//�ܰ� �����ִ� �޼ҵ�
	public void showMoney(String pw) {
		if(this.pw.equals(pw)) {
			System.out.println(this.name+"���� �ܰ��"+this.nowMoney+"�� �Դϴ�." );
		}else {
			System.out.println("�߸��� ��й�ȣ �Դϴ�.");
		}
	}
	
}
