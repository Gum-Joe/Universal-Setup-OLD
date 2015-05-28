cd ProgramFile
arr=(./*)

# iterate through array using a counter
for ((i=0; i<${#arr[@]}; i++)); do
    #do something to each element of array
    echo "${arr[$i]}"
done

echo $arr > index.txt
NAME="$(sed -n '4p' info.yml)"

for ((b=1; b<${#arr[@]}; b++)); do
    #do something to each element of array
    b="$b""p"
    echo $b
    INDEX="$(sed -n '$b' index.txt)"
    echo Coppying $INDEX
    cp -v./ProgramFiles/$INDEX ./TestDir/$NAME
done