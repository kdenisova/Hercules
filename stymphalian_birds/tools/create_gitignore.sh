if [ "$#" -ne 1 ]
then
    echo "usage: sh $0 <directory_name>"
else
	DIRECTORY=$1
	echo "*.DS_Store" > $DIRECTORY/.gitignore
	echo "a.out" >> $DIRECTORY/.gitignore
	echo ".vscode" >> $DIRECTORY/.gitignore
fi
exit 0
