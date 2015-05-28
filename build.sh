
LANG="$(sed -n '2p' info.yml)"
if [ "$LANG" = "lang: java" ]; then
  mvn clean install
fi