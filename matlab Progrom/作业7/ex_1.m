function ex_1()
fmin='2*exp(-x)*cos(x)';
[xmin,ymin]=fminbnd(fmin,0,20)
fmax='-2*exp(-x)*cos(x)';
[xmax,ymax]=fminbnd(fmax,0,20)
