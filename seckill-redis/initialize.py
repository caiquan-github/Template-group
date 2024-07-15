import redis

# 连接 Redis 服务器
client = redis.StrictRedis(host='192.168.10.101', port=6379, db=0)


def initialize():
    stock_key = 'product_stock_list'
    user_key = 'product_user_purchased'

    # 初始化商品库存列表
    client.delete(stock_key)
    for _ in range(100):  # 假设库存为100
        client.lpush(stock_key, 1)

    # 清空用户购买记录
    client.delete(user_key)
    print("初始化完成：商品库存设置为100，用户购买记录已清空")


if __name__ == "__main__":
    initialize()
