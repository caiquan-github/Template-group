-- 秒杀系统 Lua 脚本，使用 Redis list 实现

-- KEYS[1]: 商品库存列表键
-- KEYS[2]: 用户购买记录键
-- ARGV[1]: 用户ID

-- 获取商品库存列表键和用户购买记录键
local stockKey = KEYS[1]
local userKey = KEYS[2]

-- 获取用户ID
local userId = ARGV[1]

-- 检查用户是否已经购买过
local userHasBought = redis.call('SISMEMBER', userKey, userId)
if userHasBought == 1 then
    return 2  -- 用户已经购买过
end

-- 尝试从库存列表中弹出一个元素
local stock = redis.call('RPOP', stockKey)
if not stock then
    return 0  -- 库存不足
end

-- 记录用户购买行为
redis.call('SADD', userKey, userId)

-- 秒杀成功
return 1
