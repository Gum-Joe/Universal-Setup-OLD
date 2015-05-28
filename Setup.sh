
TYPE="$(sed -n '1p' info.yml)"
if [ "$TYPE" = "type: install" ]; then
  ./install.sh
fi

if [ "$TYPE" = "type: build" ]; then
  ./build.sh
fi