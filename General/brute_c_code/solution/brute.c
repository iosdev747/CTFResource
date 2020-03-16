#include<stdio.h>
#include<stdlib.h>

void f() {
  printf("Strings_");
  printf("will_not");
  printf("_always_");
}

int main() {
 long int a;
/*
9702697867‬
*/
 scanf("%ld", &a);
printf("\n\n\n%ld\n", a);
 a-=8000000000;
//1702697867‬
printf("%ld\n", a);
 a^=0x346cc;
//1702780231‬
printf("%ld\n", a);
 a-=-a;
//3405560462‬
printf("%ld(%ld)(%ld)\n", a, a&0xcffcffcf, 0xcafebabe&0xcffcffcf);
 if((a&0xcffcffcf) == (0xcafebabe&0xcffcffcf))
  goto a;
 else
  goto wrong;
  printf("0");
  printf("x");
  printf("4");
  printf("9");
  printf("Strings_");
  printf("not");
  printf("_always_");
  a:
  printf("f");
  goto b;
  dsd:
  printf("t");
  printf("e ");
  goto adf;
  c:
  printf("g ");
  goto f;
  e:
  printf("b");
  goto k;
  b:
  printf("l");
  goto d;
  adf:
  printf("f");
  goto gh;
  k:
  printf("ru");
  goto dsd;
  printf("");
  d:
  printf("a");
  goto c;
  cpp:
  printf(" n0");
  goto gg;
  gg:
  printf("0");
  goto gghh;
  f:
  printf("is ");
  goto e;
  kn:
  printf("ce ");
  goto pc;
  gghh:
  printf("b");
  goto end;
  gh:
  printf("0r");
  goto kn;
  pc:
  printf("W0rkzzz");
  goto cpp;
  wrong:
  printf("Wrong phone number.   :(\n");
  end:
 return 0;
}
