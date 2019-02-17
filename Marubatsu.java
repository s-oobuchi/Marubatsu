import java.util.Scanner;

public class Marubatsu {
	public static void main(String[] args) {

		//配列定義
		String[][] array;
		array = new String[3][3];

		//初期値設定
		for(int i = 0;i < 3;i++ ){

			for(int j = 0;j < 3;j++ ){

		        array[i][j] = "ok";

			}

		}

		//プレーヤー名
		String name;

		//〇×格納
		String stone;

		//ループカウント
		int count = 0;

		//ループ判定
		boolean repeat = true;

		while(repeat){

			//カウントが奇数か偶数か判断しプレーヤーを切り替える
			if (count % 2 == 0){

				stone = "〇";
				name = "Aさん";

			} else {

				stone = "×";
				name = "Bさん";

		    }

			System.out.println(name + "の番です");
			System.out.println("縦を入力してください");

		    Scanner scan = new Scanner(System.in);

		    //盤面の範囲外の時もう一度入力
		    int value1 = scan.nextInt();

		    if(value1 < 0 && value1 > 2){

		    	System.out.println("もう一度数字を入力してください");
		        continue;

		    }

		    System.out.println("横を入力してください");

		    int value2 = scan.nextInt();

		    if(value2 < 0 && value2 > 2){

		        System.out.println("もう一度数字を入力してください");
		        continue;

		    }

		    //盤面にすでに配置されている場合
		    if (array[value1][value2] != "ok"){

		        System.out.println("すでに石が置いてあります。もう一度入力してください");

		        continue;

		    }

		    array[value1][value2] = stone;

		    for(int i = 0; i < 3; i++ ){

		        for(int j = 0; j < 3; j++ ){

		        	System.out.print(array[i][j]);

		        	if(j==2){

		        		continue;

		        	}

		        	System.out.print(" |");

		        }

		        System.out.println();

		    }

		    //縦に揃っている場合
		    if((array[0][0] == stone && array[0][1] == stone && array[0][2] == stone)
		    		||(array[1][0] == stone && array[1][1] == stone && array[1][2] == stone)
		    		||(array[2][0] == stone && array[2][1] == stone && array[2][2] == stone)){

		    	System.out.println(name + "の勝ちです。");
		    	scan.close();

		        break;

		    }

		    //横に揃っている場合
		    if((array[0][0] == stone && array[1][0] == stone && array[2][0] == stone)
		    		||(array[0][1] == stone && array[1][1] == stone && array[2][1] == stone)
		    		||(array[0][2] == stone && array[1][2] == stone && array[2][2] == stone)){

		        System.out.println(name + "の勝ちです。");
		        scan.close();

		        break;

		    }

		    //左上から右下に斜めに揃っている場合
		    if(array[0][0] == stone && array[1][1] == stone && array[2][2] == stone){

		        System.out.println(name + "の勝ちです。");
		        scan.close();

		        break;

		    }

		    //左下から右上に斜めに揃っている場合
		    if(array[0][2] == stone && array[1][1] == stone && array[2][0] == stone){

		        System.out.println(name + "の勝ちです。");
		        scan.close();

		        break;

		    }

		    //最後のターンの場合
		    if (count == 8){

		        System.out.println("あいこです。");
		        repeat = false;
		        scan.close();

		    }

		    count++;

		    }

		  }

		}