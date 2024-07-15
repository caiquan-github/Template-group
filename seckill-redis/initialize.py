import redis

# 连接 Redis 服务器
client = redis.StrictRedis(host='192.168.10.101', port=6379, db=0)

def initialize():
    # 初始化商品库存
    client.set('product_stock', 100)
    # 清空用户购买记录
    client.delete('user_purchased')
    print("初始化完成：商品库存设置为100，用户购买记录已清空")

if __name__ == "__main__":
    initialize()
