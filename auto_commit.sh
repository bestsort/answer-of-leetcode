git pull
git add .
info="auto commit: $(date "+%Y-%m-%d %H:%M:%S")"
echo $info
git commit -m "$info"
git push