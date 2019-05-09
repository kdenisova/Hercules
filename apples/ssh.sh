if [ "$#" -ne 2 ]
then
	echo "usage: sh $0 <user_name> <host_address>"
	exit 0
fi

echo "Creating keys..."
echo ""

ssh-keygen -t rsa -b 2048

echo ""
echo "Copying the public key to Virtual Machine..."
echo ""

ssh-copy-id $1@$2

echo ""
echo "Connecting to Virtual Machine..."
echo ""

ssh $1@$2
