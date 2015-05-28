echo Installing...
if [ ! -f ./ProgramFiles/* ]; then
  echo "Programme File not found, contact the programme's author to tell them about this issue"
  exit 1
fi
NAME="$(sed -n '4p' info.yml)"
CreateArray.sh
echo Updateing Component Registry...
if [ ! -f ./registray.xml ]; then
    echo Component reg does not exit, creating...
    echo "<programs>
            <program>$NAME</program>
          </programs>
    " > registray.xml
else
echo "
            <program>$NAME</program>
    " > registray.xml
fi