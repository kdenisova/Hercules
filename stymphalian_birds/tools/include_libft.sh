if [ "$#" -ne 1 ]
then
	echo "usage: sh $0 <libft_path>"
else
	DIRECTORY=$1
	mkdir -p $DIRECTORY/libft
	read -p "Enter location of libft: ~/" libft_path
    cp -R ~/$libft_path/* "$DIRECTORY/libft"
fi
exit 0
