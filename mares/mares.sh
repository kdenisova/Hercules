./manger &

sleep 7

kill -s KILL $(top -l 1 | grep manger | cut -d" " -f1)

rm -rf *.poo

gcc -o my_mares my_mares.c

./my_mares &

sleep 7

kill -s KILL $(top -l 1 | grep my_mares | cut -d" " -f1)
