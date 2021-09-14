public class Account {
	String acc, name, pw; // 계좌번호, 이름,비밀번호
	int nowMoney, money=0; //잔고, 입출금에 사용할 돈
	int minusLine; //마이너스 통장
	
	
	//생성자 계좌번호, 이름, 비밀번호, 금액을 입력받고 초기화를 함.
	public Account(String acc, String name, String pw, int nowMoney) {
		this.acc = acc;
		this.name = name;
		this.pw = pw;
		this.nowMoney = nowMoney;
	}
	
	//생성자 다형성 금액을 입력받지 않으면 금액을 0으로 리턴한다.
	public Account(String acc, String name, String pw) {
		this(acc, name, pw, 0);
	}
	
	//입금 메소드
	public int credit(int money) {
		return this.nowMoney+=money; 
	}
	
	//출금 메소드, 비밀번호와 보낼금액을 매개변수로 받고 확인 후 출금 실행 or 실패처리.
	public int debit(String pw, int money) {
		if(this.pw.equals(pw)) {
			if(this.nowMoney-money>=0) {
				return this.nowMoney-=money;
			}else {
				System.out.println("잔액이 부족합니다.");
			}
		}else {
			System.out.println("잘못된 비밀번호 입니다.");
		}
		
		return 0;
	}
	
	//송금 메소드, 상대방계좌, 비밀번호, 보낼금액을 매개변수로 받아옴
	//상대방계좌와 비밀번호 확인 후 메소드 실행 or 실패처리
	public boolean send(Account sendAcc, String pw, int money) {
		int result = this.debit(pw, money);
		if(result!=0) {
			sendAcc.credit(money);
			return true;
		}
		return false;
	}
	
	//잔고를 보여주는 메소드
	public void showMoney(String pw) {
		if(this.pw.equals(pw)) {
			System.out.println(this.name+"님의 잔고는"+this.nowMoney+"원 입니다." );
		}else {
			System.out.println("잘못된 비밀번호 입니다.");
		}
	}
	
}
