// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Enum.java

package com.atguigu.myexer1;

import java.io.PrintStream;

// Referenced classes of package com.atguigu.myexer1:
//			Week

public class Enum
{

	public Enum()
	{
	}

	public static void main(String args[])
	{
		int num = Integer.parseInt(args[0]);
		Week weeks[] = Week.values();
		printWeek(weeks[num - 1]);
		System.out.println(weeks[num - 1]);
	}

	static void printWeek(Week week)
	{
		static class 1
		{

			static final int $SwitchMap$com$atguigu$myexer1$Week[];

			static 
			{
				$SwitchMap$com$atguigu$myexer1$Week = new int[Week.values().length];
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.MON.ordinal()] = 1;
				}
				catch (NoSuchFieldError nosuchfielderror) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.TUE.ordinal()] = 2;
				}
				catch (NoSuchFieldError nosuchfielderror1) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.WED.ordinal()] = 3;
				}
				catch (NoSuchFieldError nosuchfielderror2) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.THU.ordinal()] = 4;
				}
				catch (NoSuchFieldError nosuchfielderror3) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.FRI.ordinal()] = 5;
				}
				catch (NoSuchFieldError nosuchfielderror4) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.SAT.ordinal()] = 6;
				}
				catch (NoSuchFieldError nosuchfielderror5) { }
				try
				{
					$SwitchMap$com$atguigu$myexer1$Week[Week.SUN.ordinal()] = 7;
				}
				catch (NoSuchFieldError nosuchfielderror6) { }
			}
		}

		switch (1..SwitchMap.com.atguigu.myexer1.Week[week.ordinal()])
		{
		case 1: // '\001'
			System.out.println("星期一");
			break;

		case 2: // '\002'
			System.out.println("星期二");
			break;

		case 3: // '\003'
			System.out.println("星期三");
			break;

		case 4: // '\004'
			System.out.println("星期四");
			break;

		case 5: // '\005'
			System.out.println("星期五");
			break;

		case 6: // '\006'
			System.out.println("星期六");
			break;

		case 7: // '\007'
			System.out.println("星期七");
			break;
		}
	}
}
