if [ "$#" -ne 3 ]
then
    echo "usage: sh $0 <directory_name> <project_name> <flag>"
elif [ "$3" -ne 1 ] 
then
    DIRECTORY=$1
    PROJECT=$2
	sh tools/create_header.sh Makefile $DIRECTORY 
	echo "NAME = $( echo "$PROJECT" )" >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'FLAGS = -Wall -Wextra -Werror' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'SRC = <file_name.c>' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'OBJECTS = $(SRC:.c=.o)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'all: $(NAME)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo '$(NAME):' >>$DIRECTORY/Makefile
	echo '		gcc $(FLAGS) -o $(NAME) $(SRC)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'clean:' >> $DIRECTORY/Makefile
	echo '		@rm -f $(OBJECTS)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'fclean: clean' >> $DIRECTORY/Makefile
	echo '		@rm -f $(NAME)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 're: fclean all' >> $DIRECTORY/Makefile
else
    DIRECTORY=$1
    PROJECT=$2
	sh tools/create_header.sh Makefile $DIRECTORY
	echo "NAME = $( echo "$PROJECT" )" >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'FLAGS = -Wall -Wextra -Werror' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'SRC = <file_name.c>' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'OBJECTS = $(SRC:.c=.o)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'all: $(NAME)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo '$(NAME): lib' >>$DIRECTORY/Makefile
	echo '		gcc $(FLAGS) -o $(NAME) -I./libft -L./libft -lft $(SRC)' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'lib:' >> $DIRECTORY/Makefile
	echo '		@make -C libft' >> $DIRECTORY/Makefile
	echo 'clean:' >> $DIRECTORY/Makefile
	echo '		@rm -f $(OBJECTS)' >> $DIRECTORY/Makefile
	echo '		@make -C libft/ clean' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 'fclean: clean' >> $DIRECTORY/Makefile
	echo '		@rm -f $(NAME)' >> $DIRECTORY/Makefile
	echo '		@make -C libft/ fclean' >> $DIRECTORY/Makefile
	echo '' >> $DIRECTORY/Makefile
	echo 're: fclean all' >> $DIRECTORY/Makefile
fi
