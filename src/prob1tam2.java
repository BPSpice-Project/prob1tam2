
import java.util.Scanner;
public class prob1tam2 {
    public static void main(String[] arg){
        Scanner in=new Scanner(System.in);
        poly a,b;
        String s;
        s=in.nextLine();
        a=new poly(s);
        s=in.nextLine();
        b=new poly(s);
        a.zarb(b);
    }
}
class poly{
    int [] n=new int[1000],m=new int[1000];;
    int deg=0;
    poly (String s1) {
        int q=1,tavan=0,flag=0,zarib=0;
        if (s1.length()==1&&s1.charAt(0)=='x'){
            n[1]=1;
            deg=1;
        }
        else {
            while (flag < s1.length()) {
                tavan = 0;
                zarib = 0;
                if (s1.charAt(flag) == '+') {
                    flag++;
                    q = 1;
                }
                if (s1.charAt(flag) == '-') {
                    flag++;
                    q = -1;
                }
                while (s1.charAt(flag) >= '0' && s1.charAt(flag) <= '9') {
                    zarib *= 10;
                    zarib += s1.charAt(flag) - '0';
                    flag++;
                    if (flag >= s1.length()) break;
                }
                if (flag == s1.length() && s1.charAt(flag - 1) != 'x') n[0] += q * zarib;
                if (flag >= s1.length()) break;
                if (s1.charAt(flag) != 'x') tavan = 0;
                if (flag < s1.length() - 1 && s1.charAt(flag) == 'x') flag++;
                if (s1.charAt(flag) == '^') {
                    flag++;
                    while (s1.charAt(flag) >= '0' && s1.charAt(flag) <= '9') {
                        tavan *= 10;
                        tavan += s1.charAt(flag) - '0';
                        flag++;
                        if (flag >= s1.length()) break;
                    }

                } else if (s1.charAt(flag - 1) == 'x' || (s1.charAt(flag) == 'x' && flag == s1.length() - 1)) tavan = 1;
                if (zarib == 0) zarib = 1;
                n[tavan] += q * zarib;
                if (tavan > deg) deg = tavan;
                if (flag >= s1.length()) break;
                if ((s1.charAt(flag) == 'x' && flag == s1.length() - 1)) break;
            }
        }
    }
    void zarb(poly b)
    {
        int i=0,j=0;
        for(i=0;i<=deg;i++){
            for (j=0;j<=b.deg;j++)
                m[i+j]+=n[i]*b.n[j];
        }
        if (m[deg+b.deg]==1&&deg+b.deg>1) System.out.printf("x^%d",deg+b.deg);
        if (m[deg+b.deg]==-1&&deg+b.deg>1) System.out.printf("-x^%d",deg+b.deg);
        if (m[deg+b.deg]>1&&deg+b.deg>1) System.out.printf("%dx^%d",m[deg+b.deg],deg+b.deg);
        if (m[deg+b.deg]<-1&&deg+b.deg>1) System.out.printf("%dx^%d",m[deg+b.deg],deg+b.deg);
        for (i=deg+b.deg-1;i>1;i--)
        {
            if (m[i]>1) System.out.printf("+%dx^%d",m[i],i);
            if (m[i]<-1) System.out.printf("%dx^%d",m[i],i);
            if (m[i]==1) System.out.printf("+x^%d",m[i],i);
            if (m[i]==-1) System.out.printf("-x^%d",m[i],i);
        }
        if (m[1]>1) System.out.printf("+%dx",m[1]);
        if (m[1]<-1) System.out.printf("%dx",m[1]);
        if (m[0]>=1) System.out.printf("+%d",m[0]);
        if (m[0]<=-1) System.out.printf("%d",m[0]);
        if (m[1]==1) System.out.printf("+x");
        if (m[1]==-1) System.out.printf("-x");
    }
}
