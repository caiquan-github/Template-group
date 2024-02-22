import requests

url = "https://www.zhipin.com/wapi/zpgeek/search/joblist.json?scene=1&query=&city=101250100&experience=&payType=&partTime=&degree=&industry=&scale=&stage=&position=100101&jobType=&salary=&multiBusinessDistrict=&multiSubway=&page=2&pageSize=30"

payload = {}
headers = {
    'authority': 'www.zhipin.com',
    'accept': 'application/json, text/plain, */*',
    'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8',
    'cookie': 'wd_guid=3f0964f3-c687-4127-8c11-b7132aeb6536; historyState=state; _bl_uid=e7l2Fl6Ohd5k6b7OnwqCk4kaL2LI; lastCity=101250100; __zp_seo_uuid__=651b6ce5-97ea-4220-b9f0-c69d787a9f14; __g=-; boss_login_mode=app; wt2=DCP83r2iTDyvG5Z2CbG17D1XvzRBoa0e3O4E3FI6fHxYfYWbYXTotEb5HkXSU3M371iGfGCJJqTLnWOK-s1uGoQ~~; wbg=0; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1695260540; __l=r=https%3A%2F%2Fwww.google.com%2F&l=%2Fwww.zhipin.com%2Fweb%2Fgeek%2Fresume&s=3&g=&friend_source=0&s=3&friend_source=0; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1695442849; __c=1692421531; __a=47489115.1692421531..1692421531.273.1.273.273; geek_zp_token=V1RNwiFeT92V9gXdNgyhkcKi-35TnWxg~~; __zp_stoken__=dc24eC2N4DX0gBA40RE0QdWhzdAdULXRdUxkERSZHEFsgbxhQdBdxSwASFHMnGA9XQW5%2BEzB0E2pALhMEVFw6YFYhQ14jHxwbS2AxS3NeYwIzCSAqE3MiZEJXZSpEaCAGA1dMbDUAbG8JPBY%3D',
    'referer': 'https://www.zhipin.com/web/geek/job?query=&city=101250100&position=100101&page=2',
    'sec-ch-ua': '"Chromium";v="116", "Not)A;Brand";v="24", "Google Chrome";v="116"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"Windows"',
    'sec-fetch-dest': 'empty',
    'sec-fetch-mode': 'cors',
    'sec-fetch-site': 'same-origin',
    'token': 'HGtTMSPwyqm1998',
    'traceid': '7CD07211-C0D7-4D56-8477-3E2D7ED77051',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36',
    'x-requested-with': 'XMLHttpRequest',
    'zp_token': 'V1RNwiFeT92V9gXdNgyhkcKi-35TnWxg~~'
}

response = requests.request("GET", url, headers=headers, data=payload)

print(response.text)
