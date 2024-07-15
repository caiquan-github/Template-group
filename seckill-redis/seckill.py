# coding=utf-8
import redis

# 连接 Redis 服务器
client = redis.StrictRedis(host='192.168.10.101', port=6379, db=0)


def seckill(user_id):
    with open('seckill.lua', 'r', encoding='utf-8') as file:
        lua_script = file.read()

    # 将 Lua 脚本加载到 Redis
    script = client.register_script(lua_script)

    # 执行 Lua 脚本
    result = script(keys=['product_stock_list', 'product_user_purchased'], args=[user_id])

    # 根据结果返回相应的消息
    if result == 0:
        return "库存不足"
    elif result == 2:
        return "用户已经购买过"
    elif result == 1:
        return "秒杀成功"
    else:
        return "未知错误"


def add(user_id):
    # 示例用户 ID
    user_id = user_id
    # 执行秒杀操作
    result = seckill(user_id)
    print(result)


if __name__ == "__main__":
    for i in range(103):  # 假设库存为100
        add('user:'+i.__str__())
