
public class ogamdo {

	public static void main(String[] args)
	{
		int ahae = 13;
		System.out.println(ahae + "인의 아해가 도로로 질주하오.");
		System.out.println("(길은 막다른 골목이 적당하오.)\n");
		
		for(int i = 1; i <= ahae; i++ )
			if(i == 1)
				System.out.println("제" + i + "의 아해가 무섭다고 그리오.");
			else if(i == 10)
			{
				System.out.println("제" + i + "의 아해도 무섭다고 그리오.");
				System.out.println();
			}else
				System.out.println("제" + i + "의 아해도 무섭다고 그리오.");
		
		System.out.println(ahae +"인의 아해는 무서운 아해와 무서워하는 아해와 그렇게 뿐이 모였소.");
		System.out.println("(다른 사정은 없는 것이 차라리 나았소)\n");
		int j = 0;
		while(j != 4)
		{
			if( j < 2 )
				System.out.println("그중에 " + (j + 1) + "인의 아해가 무서운 아해라도 좋소.");
			else
				System.out.println("그중에 " + (j * 2 + 1) % 3 +"인의 아해가 무서워하는 아해라도 좋소.");
			j++;
		}
		System.out.println("(길은 뚫린 골목이라도 적당하오.)\n");
		System.out.println(ahae + "인의 아해가 도로로 질주하지 아니 하여도 좋소.");
	}
}
