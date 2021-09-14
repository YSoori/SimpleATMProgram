package C0901_Practice_Acc;

import java.util.*;


public class ATM_Test {
	
	static void showAcc(Account[] arr, int cnt) {
		boolean check=false;
		for(int i=0;i<cnt;i++) {
			System.out.println(arr[i].name + " / " + arr[i].acc);
			check=true;
		}
		if(check==false) {
			System.out.println("��ϵ� ���°� �����ϴ�.");
		}
	}
	
	static Account findAcc(Account[] arr, int cnt, String acc) {
		for(int i=0;i<cnt;i++) {
			if(arr[i].acc.equals(acc)) {
				return arr[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String acc, name, pw, sendA;
		int nowMoney, money, cnt=0;
		Account[] account = new Account[100];
		Account curr = null, sendAcc = null;
		
		Scanner sc = new Scanner(System.in);
	
		int but1 = 0;
		
		System.out.println("ATM ���α׷��� �����մϴ�.");
		while(but1!=4) {
			int but2 = 0;
			System.out.println("1.���� ��� 2.��� ���� ��ȸ 3.�α��� 4.����");
			but1 = sc.nextInt();
			
			switch(but1) {
			case 1: 
				System.out.println("������ : "); name = sc.next();
				System.out.println("���¹�ȣ : "); acc = sc.next();
				if(findAcc(account, cnt, acc)==null) {
					System.out.println("��й�ȣ : "); pw = sc.next();
					System.out.println("�Ա��� �ݾ� : "); money = sc.nextInt();
					account[cnt] = new Account(acc, name, pw, money);
					System.out.println(account[cnt].name+"���� ���°� �����Ǿ����ϴ�.");
					cnt++;
				}else {
					System.out.println("�̹� ��ϵ� ���¹�ȣ�Դϴ�.");
				}
				break;
			case 2:
				showAcc(account, cnt);
				break;
			case 3:
				if(account[0]==null) {
					System.out.println("��ϵ� ���°� �����ϴ�.");
				}else {
					System.out.println("���¹�ȣ : "); acc=sc.next();
					curr = findAcc(account, cnt, acc);
					if(curr!=null) {
						System.out.println(curr.name+"�� �ݰ����ϴ�.");
						System.out.println("���� ȭ������ �̵��մϴ�.");
						
						while(but2!=5) {
							System.out.println("1.��ȸ 2.�Ա� 3.��� 4.�۱� 5.�α׾ƿ�");
							but2=sc.nextInt();
							
							switch(but2) {
							case 1:
								System.out.println("��й�ȣ : "); pw = sc.next();
								curr.showMoney(pw);
								break;
							case 2:
								System.out.println("�Աݾ� : "); money = sc.nextInt();
								curr.credit(money);
								System.out.println(money+"�� �Ա޵Ǿ����ϴ�.");
								break;
							case 3:
								System.out.println("��й�ȣ : "); pw = sc.next();
								System.out.println("��ݾ� : "); money = sc.nextInt();
								
								if(curr.debit(pw, money)!=0) {
									System.out.println(money+"�� ��ݵǾ����ϴ�.");
								}
								
								break;
							case 4: 
								System.out.println("�۱��� ���� : "); sendA = sc.next();
								System.out.println("�۱ݾ� : "); money = sc.nextInt();
								System.out.println("��й�ȣ : "); pw = sc.next();
								sendAcc = findAcc(account, cnt, sendA);
								if(sendAcc!=null) {
									curr.send(sendAcc, pw, money);
								}
								break;
							case 5: 
								System.out.println("ó�� ȭ������ ���ư��ϴ�.");
								break;
							default:
								System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
								break;
							}
						}
					}else {
						System.out.println("��ϵ��� ���� ���¹�ȣ�Դϴ�.");
					}
				}
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�ùٸ� ��ȣ�� �Է����ּ���.");
				break;
			
			}
		}
	}
}
