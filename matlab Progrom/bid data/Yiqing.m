d=0:10:350;
      D=[];
      V=[];
      for i=1:length(d)
        n=d(i)/10;
        D=[D ones(1,n)*d(i)];
        V=[V 1:n];
      end
      figure
      wind_rose(D,V)